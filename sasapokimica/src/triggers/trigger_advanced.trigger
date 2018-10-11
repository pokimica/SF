trigger trigger_advanced on Opportunity (After insert) {
contact c = new contact();

for (opportunity a: Trigger.new){
  c.AccountID = a.AccountID;
  c.FirstName = 'Steve';
  c.LastName = 'Jobs';
  insert c;
}

}