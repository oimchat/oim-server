abstract class BaseRouteConfig {

    public abstract getTitle(): string;

    public abstract getKey(): string;

    public abstract getRoutes(): [];
}

export default BaseRouteConfig;
