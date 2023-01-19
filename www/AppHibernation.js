
class AppHibernation extends tabris.Widget {

    get _nativeType() {
        return 'plugin.AppHibernation';
    }

    openAppSettings() {
        return this._nativeCall('openAppSettings');
    }

}

tabris.NativeObject.defineProperties(AppHibernation.prototype, {
    enabled: { readonly: true, const: true },
});

module.exports = AppHibernation;