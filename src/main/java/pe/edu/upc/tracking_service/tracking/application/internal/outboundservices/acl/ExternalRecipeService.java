package pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources.RecipeNutritionResource;
import pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources.RecipeResource;
import pe.edu.upc.tracking_service.tracking.domain.model.valueobjects.RecipeId;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalRecipeService {

    private final RestClient restClient;

    public ExternalRecipeService(
            @Qualifier("loadBalancedRestClientBuilder") RestClient.Builder restClientBuilder,
            @Value("${services.recipes.base-url}") String recipesBaseUrl) {
        this.restClient = restClientBuilder
                .baseUrl(recipesBaseUrl)
                .build();
    }

    public boolean existsByRecipeId(RecipeId recipeId) {
        return getRecipeById(recipeId).isPresent();
    }

    public Optional<RecipeResource> getRecipeById(RecipeId recipeId) {
        try {
            return Optional.ofNullable(restClient.get()
                    .uri("/api/v1/recipes/{recipeId}", recipeId.recipeId())
                    .retrieve()
                    .body(RecipeResource.class));
        } catch (RestClientException | IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public boolean existsByName(String name) {
        try {
            Boolean exists = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/v1/recipes/exists")
                            .queryParam("name", name)
                            .build())
                    .retrieve()
                    .body(Boolean.class);
            return Boolean.TRUE.equals(exists);
        } catch (RestClientException | IllegalArgumentException e) {
            return false;
        }
    }

    public List<RecipeResource> getAllRecipes() {
        try {
            List<RecipeResource> recipes = restClient.get()
                    .uri("/api/v1/recipes")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return recipes == null ? List.of() : recipes;
        } catch (RestClientException | IllegalArgumentException e) {
            return List.of();
        }
    }

    public Optional<RecipeNutritionResource> fetchNutritionByRecipeId(RecipeId recipeId) {
        try {
            return Optional.ofNullable(restClient.get()
                    .uri("/api/v1/recipes/{recipeId}/nutrition", recipeId.recipeId())
                    .retrieve()
                    .body(RecipeNutritionResource.class));
        } catch (RestClientException | IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
