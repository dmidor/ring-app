'use strict';

angular
    .module('ring')
    .provider('routing', routingProvider);


function routingProvider() {

    var routing = {
        configure: function (prefix, templatePath, title, controller, controllerAs, reloadOnSearch) {
            var routeConfig = {
                controller: controller || prefix + 'Controller',
                controllerAs: controllerAs || 'vm',
                templateUrl: templatePath + '/' + prefix + 'View.html',
                title: title,
                reloadOnSearch : reloadOnSearch
            };
            return routeConfig;
        }
    };

    this.$get = function () {
        return routing;
    };
}