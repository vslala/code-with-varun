interface IntegrationService {
    save: (count: number) => Promise<void>;
    fetch: () => Promise<number>;
}
class LocalIntegrationService implements IntegrationService {
    fetch(): Promise<number> {
        let count = localStorage.getItem("counter");
        if (count) {
            return Promise.resolve(JSON.parse(count) as number);
        }

        throw Error("count not found!");
    }

    save(count: number): Promise<void> {
        localStorage.setItem("counter", JSON.stringify(count));
        return Promise.resolve();
    }

}

class RemoteIntegrationService implements IntegrationService {
    fetch(): Promise<number> {
        throw Error("Method not implemented!");
    }

    save(count: number): Promise<void> {
        throw Error("Method not implemented!");
    }

}

class IntegrationServiceProvider {
    private static instance: IntegrationService;

    private constructor() {
    }

    static getInstance() {
        if (this.instance) {
            return this.instance;
        }

        const env = process.env.NODE_ENV;
        switch (env) {
            case "development":
                this.instance = new LocalIntegrationService();
                break;
            case "production":
                this.instance = new RemoteIntegrationService();
                break;
            default:
                throw Error(`No service found for the given env: ${env}`);
        }

        return this.instance;
    }
}

export type {
    IntegrationService
}

export {
    IntegrationServiceProvider
}

