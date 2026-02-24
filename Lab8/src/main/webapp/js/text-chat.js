var websocket = null;

function init() {
    websocket = new WebSocket('ws://localhost:8080/Lab8/text/chat');

    websocket.onopen = function (resp) {
        console.log("onopen", resp);
    }

    websocket.onmessage = function (resp) {
        var message = resp.data;
        var html = document.getElementById('messages').innerHTML;
        document.getElementById('messages').innerHTML =  `${html}<p>${message}</p>`;
        console.log("onmessage", resp.data);
    }

    websocket.onerror = function (resp) {
        alert('An error occured closing application');
        console.log("onerror", resp);
    }

    websocket.onclose = function (resp) {
        alert(resp.reason || 'Goodbye');
        console.log("onclose", resp);
    }

    function send() {
        var message = document.getElementById("message").value;
        websocket.send(message);
        document.getElementById("message").value = "";
    }
}