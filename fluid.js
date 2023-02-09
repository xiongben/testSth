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
        var dialogDom = $(
            '<div class="fluid-xb-bg">'+
                '<div class="fluid-xb-box">'+
                    '<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAlCAYAAAAqXEs9AAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAADYSURBVHgB1ZXrCcMwEINFJ9H+S3iUjpImkEIKbey7k1LnwPiH9fjAeQCfw3W1fXcPe13bwXNdy74TXpjTrqNggReKva5vAhcUR7raD4Eaiicw79VGhVUoRjvCBidM2eiAkQU4shRBigxZYMUrh8p4bFARbWk4WHQJTATqMpgqlAUmC2WFiUKlYB64+RATXRkx0UNNTPTaExN9GImJfh1MFGQ8NhiFVw6jzNAGKbLKAcrMtNEBFTa4oRq8MBGo1hOqYEagutemhgl3HYUumHDXdtDghflHV35e5EwCm+oUFI0AAAAASUVORK5CYII=" class="fluid-xb-close">'+
                        '<iframe src="http://localhost:8082/#/home?order_number=627648719168212992&company_id=111" class="fluid-xb-iframe-box"></iframe>'+
                '</div>'+
            '</div>'
        )
        $("body").append(dialogDom)
        console.log($)
    }
}