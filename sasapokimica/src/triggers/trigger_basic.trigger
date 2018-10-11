trigger trigger_basic on Opportunity (Before insert, Before update) {
    for (opportunity a: Trigger.new){
        if (a.Amount < 501){
            a.adderror('Amount value should be greater than 500');
        }
    }
}