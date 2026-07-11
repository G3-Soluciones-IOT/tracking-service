package pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources;

import java.util.List;

public record UserProfileResource(
        Long id,
        String gender,
        double height,
        double weight,
        int userScore,
        String birthDate,
        Long activityLevelId,
        String activityLevelName,
        Long objectiveId,
        String objectiveName,
        List<String> allergyNames
) {
}
