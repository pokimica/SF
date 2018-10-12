({
	getAccounts : function(cmp) {
		var action = cmp.get("c.getContacts");
		action.setCallback(this, function(response){
			var state = response.getState();
			var toastEvent = $A.get("e.force:showToast");
			
			if (state == "SUCCESS") {
				cmp.set("v.accounts", response.getReturnValue());
					
				if (state === 'SUCCESS'){
					toastEvent.setParams({
						"title": "Success!",
						"message": "Your accounts have been loaded successfully."
					});
				}
			}
			else {
				toastEvent.setParams({
                        "title": "Error!",
                        "message": " Something has gone wrong."
                });
			}
			
			toastEvent.fire();
		});
		
		$A.enqueueAction(action);		
	}
})