
declare global {

    namespace plugin {

        export class AppHibernation {

            constructor();

            public getUnusedAppRestrictionsStatus(): Promise<'feature-not-available' | 'disabled' | 'enabled' | 'unknown'>;

            public openAppSettings(): void;

        }

    }

}

export {};
