package pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources.UserProfileResource;
import pe.edu.upc.tracking_service.tracking.domain.model.dto.UserProfileDto;
import pe.edu.upc.tracking_service.tracking.domain.model.valueobjects.UserId;

import java.util.Optional;

@Service
public class ExternalUserProfileService {

    private final RestClient restClient;

    public ExternalUserProfileService(
            @Qualifier("loadBalancedRestClientBuilder") RestClient.Builder restClientBuilder,
            @Value("${services.profiles.base-url}") String profilesBaseUrl) {
        this.restClient = restClientBuilder
                .baseUrl(profilesBaseUrl)
                .build();
    }

    public boolean existsByUserId(UserId userId) {
        if (userId == null || userId.userId() == null) return false;

        return existsProfile(userId.userId());
    }

    public Optional<String> getObjectiveNameByProfileId(Long profileId) {
        return fetchUserProfileDtoById(profileId)
                .map(UserProfileDto::objectiveName)
                .filter(objective -> !objective.isBlank());
    }

    public boolean existsProfile(Long profileId) {
        return fetchUserProfileDtoById(profileId).isPresent();
    }

    public void validateProfileExists(Long profileId) {
        if (!existsProfile(profileId)) {
            throw new IllegalArgumentException("Profile not found with ID: " + profileId);
        }
    }

    public String getValidatedObjectiveName(Long profileId) {
        validateProfileExists(profileId);

        return getObjectiveNameByProfileId(profileId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Profile exists but has no objective defined for ID: " + profileId));
    }

    public Optional<UserProfileDto> fetchUserProfileDtoById(Long profileId) {
        if (profileId == null) return Optional.empty();

        try {
            return Optional.ofNullable(restClient.get()
                            .uri("/api/v1/profiles/{profileId}", profileId)
                            .retrieve()
                            .body(UserProfileResource.class))
                    .map(this::mapToDto);
        } catch (RestClientException | IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    private UserProfileDto mapToDto(UserProfileResource resource) {
        double activityFactor = resource.activityLevel() == null
                ? 1.0
                : resource.activityLevel().activityFactor();
        String objectiveName = resource.objective() == null
                ? null
                : resource.objective().objectiveName();

        return new UserProfileDto(
                resource.id(),
                resource.gender(),
                resource.height(),
                resource.weight(),
                activityFactor,
                objectiveName,
                resource.birthDate()
        );
    }
}
