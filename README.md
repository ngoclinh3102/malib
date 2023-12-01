## Spring API Versioning

---

A custom annotation for multi-version API.

Supports: JDK 17, spring-boot-3.x.

### Example

- `/v1/user/list`

- `/v2/user/list`

### How to use?

```java
   @ApiVersion({1})
   @RestController
   @RequestMapping("/user")
   public class UserController {
   
      @GetMapping("/list")
      public String list1() {
        return "list1";
      }
      
      @ApiVersion({2})
      @GetMapping("/list")
      public String list2() {
        return "list2";
      }
   }
```

- Parameters: An array of versions of the method / controller (not empty, contains only non-negative integers)
- **IMPORTANT**: Methods / Controllers have the same URI cannot be used in the same version
