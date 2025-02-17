window.onload = function() {
	//$#codeExampleStart:firstRequest
    var req = new XMLHttpRequest();
    req.testId=1;
    req.open("GET", "server.php?wait=5", true);
    req.addEventListener("load", function(e) {
    	reportStatus("statusFirstRequest", "ok, got response from server", true);
    	requestDone(e);
    });
    req.addEventListener("abort", function(e) {
    	reportStatus("statusFirstRequest", "aborted when it should not be, status: " + e.target.status, false);
    	requestDone(e);
    });
    req.addEventListener("error", function(e) {
    	reportStatus("statusFirstRequest", "failed when it should not, status: " + e.target.status , false);
    	requestDone(e);
    });

    req.send();
	//$#codeExampleEnd:firstRequest
    window.setTimeout(startDownload, 1000);
};

var reportStatus = function(id, msg, ok) {
    var element = document.getElementById(id);
    element.innerHTML = msg;
    if (ok) {
    	element.style.color = "green";
    	console.log(id + ": " + msg);
    } else {
    	element.style.color = "red";
    	console.error(id + ": " + msg);
    }
}

var doneCount=0;
var test1Successful=false;
var test2Successful=false;
var requestDone = function(e) {
    doneCount++;


    if (e.target.status == 200) {
		if (e.target.testId == 1) {
		    test1Successful = true;
		} else if (e.target.testId == 2) {
		    test2Successful = true;
		}
    }

    if (doneCount == 2) {
	// both requests are done
	
	if (test1Successful && test2Successful) {
	    reportStatus("statusSummary", "ok (chrome 37+?, internet explorer?)" , true);	    
	}

	else if (!test1Successful && test2Successful) {
	    reportStatus("statusSummary", "nok: first request aborted, second ok (firefox?)" , false);	    
	}

	else if (!test1Successful && !test2Successful) {
	    reportStatus("statusSummary", "nok: both requests failed (safari other webkit or chrome <37 ?)" , false);	    
	}
    }
}

var startDownload = function() {
	//$#codeExampleStart:startDownload
    document.location.href = "server.php?action=download&wait=5";
	//$#codeExampleEnd:startDownload

	//$#codeExampleStart:secondRequest
    var req = new XMLHttpRequest();
    req.testId=2;
    req.open("GET", "server.php", true);
    req.send();
    req.addEventListener("load", function(e) {
    	reportStatus("statusSecondRequest", "ok, got response from server", true);
    	requestDone(e);
    });
    req.addEventListener("abort", function(e) {
    	reportStatus("statusSecondRequest", "aborted when it should not be, status: " + e.target.status, false);
    	requestDone(e);
    });
    req.addEventListener("error", function(e) {
    	reportStatus("statusSecondRequest", "failed when it should not, status: " + e.target.status, false);
    	requestDone(e);
    });
	//$#codeExampleEnd:secondRequest    
}
