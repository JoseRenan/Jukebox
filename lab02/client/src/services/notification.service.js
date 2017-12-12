(function () {
    'use strict';
    
    app.service('NotificationService', function (ngToast) {

        let notify = (message, className) => {
            ngToast.create({
                className: className,
                content: message,
                dismissonClick: true
            });
        }

        this.success = (message) => {
            notify(message, 'success');
        }

        this.warning = (message) => {
            notify(message, 'warning');
        }

        this.error = (message) => {
            notify(message, 'danger');
        }
    });
})();