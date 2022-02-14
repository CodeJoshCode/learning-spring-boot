// Responds to get requests with "Hello, world!"
@RestController
class ThisWillActuallyRun{

    @GetMapping("/")
    String home(){
        return "Hello, world!";
    }
}