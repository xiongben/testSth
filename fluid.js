"use strict";

const fluid = function () {
};

fluid.prototype = {
    init: function () {
        var oHead = document.getElementsByTagName('HEAD').item(0);
        var oScript= document.createElement("script");
        oScript.type = "text/javascript";
        oScript.src="https://payment-test.gofluid.io/web/jquery.js";
        oHead.appendChild( oScript);
        console.log("init fluid");
    },
    openDialog: function (url) {
        if (isMobile()) {
            window.open(url)
        } else {
            var $ = window.jQuery
            var dialogDom = $(
                '<div class="fluid-xb-bg">'+
                '<div class="fluid-xb-box">'+
                '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAlCAYAAAAqXEs9AAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAADYSURBVHgB1ZXrCcMwEINFJ9H+S3iUjpImkEIKbey7k1LnwPiH9fjAeQCfw3W1fXcPe13bwXNdy74TXpjTrqNggReKva5vAhcUR7raD4Eaiicw79VGhVUoRjvCBidM2eiAkQU4shRBigxZYMUrh8p4bFARbWk4WHQJTATqMpgqlAUmC2WFiUKlYB64+RATXRkx0UNNTPTaExN9GImJfh1MFGQ8NhiFVw6jzNAGKbLKAcrMtNEBFTa4oRq8MBGo1hOqYEagutemhgl3HYUumHDXdtDghflHV35e5EwCm+oUFI0AAAAASUVORK5CYII=" class="fluid-xb-close">'+
                '<iframe src="' + url + '" class="fluid-xb-iframe-box"></iframe>'+
                '</div>'+
                '</div>'
            )
            $("body").append(dialogDom)
            $(".fluid-xb-close").click(function (){
                $(".fluid-xb-bg").hide()
            })
        }
        console.log($)
    }
}

function isMobile() {
    let flag = navigator.userAgent.match(
        /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
    );
    return flag;
}

module.exports = {fluid}