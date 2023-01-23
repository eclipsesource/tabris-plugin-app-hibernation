
declare global {

    namespace plugin {

        export class AppHibernation {

            constructor(properties: Partial<AppHibernation>);

            public getUnusedAppRestrictionsStatus(): Promise<'feature-not-available' | 'disabled' | 'enabled' | 'unknown'>;

            public openAppSettings(): void;

        }

    }

}
