'use strict';

angular
    .module('ring', ['ngRoute', 'ngMaterial']);

angular
    .module('ring')
    .config(['$locationProvider', '$routeProvider', '$mdThemingProvider', 'routingProvider', function ($locationProvider, $routeProvider, $mdThemingProvider, routingProvider) {
        $locationProvider.hashPrefix('!');

        var routing = routingProvider.$get();

        $routeProvider
            .otherwise(routing.configure('Home', '/src/index', 'Home'));

        $mdThemingProvider.definePalette('ring-palette', {
            '50': 'edf5ea',
            '100': 'd2e5ca',
            '200': 'b5d4a7',
            '300': '97c284',
            '400': '80b569',
            '500': '6aa84f',
            '600': '62a048',
            '700': '57973f',
            '800': '4d8d36',
            '900': '3c7d26',
            'A100': 'cdffbe',
            'A200': 'a6ff8b',
            'A400': '7fff58',
            'A700': '6cff3f',
            'contrastDefaultColor': 'light',
            'contrastDarkColors': [
                '50',
                '100',
                '200',
                '300',
                '400',
                '500',
                '600',
                'A100',
                'A200',
                'A400',
                'A700'
            ],
            'contrastLightColors': [
                '700',
                '800',
                '900'
            ]
        });

        $mdThemingProvider.theme('default')
            .primaryPalette('ring-palette');
    }]);
