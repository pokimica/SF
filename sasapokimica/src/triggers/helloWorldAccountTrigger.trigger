trigger helloWorldAccountTrigger on Account (before insert) {
    ApexClassTest.addHelloWorld(Trigger.new);
}