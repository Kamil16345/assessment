function createUtil() {
	var $_jsutil = {};
	$_jsutil.__dom_window = window;
	$_jsutil.slice = Array.prototype.slice;
	$_jsutil.function_bind__currentCaller = null;
	$_jsutil.function_bind = function toolkit$jsutil$function_bind(fkt, context) {
		if (typeof fkt != "function") {
			throw "not a function: " + fkt;
		} 
	    if (arguments.length < 2 && (typeof arguments[0] === "undefined")) return this;
	    var __method = fkt, args = $_jsutil.slice.call(arguments, 2);
	    var bound = function toolkit$jsutil$bound() {
	    	var a = $_jsutil.__prototype_array_merge(args, arguments);
	    	$_jsutil.function_bind__currentCaller = arguments.callee.caller; 
	    	return __method.apply(context, a);
	    }
	    bound.toString = function() {
	    	return "[bound method context: " + context + " method: " + __method + "]";
	    }
	    return bound;
	}

	$_jsutil.dom_addEventListener = function(node, type, listener) {
		if (node.addEventListener) {	
			node.addEventListener(type, listener, false);
		} else if (node.attachEvent) {
			var proxy = new $_jsutil.__ieEventListenerProxy(listener);
			node.attachEvent("on" + type, listener);
		}
	}
	$_jsutil.__ieEventListenerProxy = function toolkit$jsutil$__ieEventListenerProxy(listener) {
		this.listener = listener;
	
		this.callback = function toolkit$jsutil$__ieEventListenerProxy$callback() {		
			listener($_jsutil.__dom_window.event);	
		}
	}
	return $_jsutil;
}
var $_jsutil = createUtil();
delete(createUtil);

