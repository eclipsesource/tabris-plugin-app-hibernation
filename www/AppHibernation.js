
class AppHibernation extends tabris.Widget {

    get _nativeType() {
        return 'plugin.AppHibernation';
    }

    getUnusedAppRestrictionsStatus() {
        return new Promise((resolve, reject) => {
            this._nativeCall('getUnusedAppRestrictionsStatus', {
                onSuccess: status => resolve(status),
                onError: message => reject(new Error(message))
            });
        });
    }

    openAppSettings() {
        return this._nativeCall('openAppSettings');
    }

}

module.exports = AppHibernation;
