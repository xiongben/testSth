"use strict";

const fluid = function () {
};

fluid.prototype = {
    init: function () {
        var oHead = document.getElementsByTagName('HEAD').item(0);
        var oScript= document.createElement("script");
        oScript.type = "text/javascript";
        oScript.src="jquery.js";
        oHead.appendChild( oScript);
        console.log("init fluid");
    },
    openDialog: function () {
        var $ = window.jQuery
        console.log($)
    }
}