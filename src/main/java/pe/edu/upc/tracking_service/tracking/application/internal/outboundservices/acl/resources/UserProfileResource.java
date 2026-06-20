package pe.edu.upc.tracking_service.tracking.application.internal.outboundservices.acl.resources;

public record UserProfileResource(
        Long id,
        String gender,
        double height,
        double weight,
        ActivityLevelResource activityLevel,
        ObjectiveResource objective,
        String birthDate
) {
    public record ActivityLevelResource(double activityFactor) {
    }

    public record ObjectiveResource(String objectiveName) {
    }
}
