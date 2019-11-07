"use stric";
(function($) {
	var app = {
		init : function() {
			this.elements();
			this.acciones();
		},
		elements:function(){
			this.$tableEmployees = $("#list-employees");
			this.tabla;
		},
		acciones:function(){
			
			
		}
	}
	return {
		init : app.init(),
	}
})(jQuery)