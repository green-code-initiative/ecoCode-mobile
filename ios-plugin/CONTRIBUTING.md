# Contributing

## General information

The iOS plugin is split into 3 different modules:
- `swift-lang` is for Swift source files parsing and checks
- `commons-ios` gather common parsing utils and models that can be reused to implement other languages support
- `sonar-ios-plugin` the actual SonarQube plugin declaration

Swift file parser is build using the [ANTLR](https://www.antlr.org/) parser generator.

The generated parser source files are located into `swift-lang/src/main/java/io/ecocode/ios/swift/antlr/generated`. those source files should not be edited manually. 

When necessary (in case of Swift language syntax upgrade for example), those source files should be re-generated with ANTLR.

## Adding new rules

When adding a new rule, the following steps are required:
- Declare the rule
- Implement a check
- Add the check to the visitor

### Declaring the rule

The new rule must be declared into 2 files :
- `swift-lang/src/resources/ecocode-swift_profile.json` 
- `swift-lang/src/resources/ecocode-swift-rules.json`

### Implementing a check

In order to implement a check for the rule, create a Check class inherited from `RuleCheck` in `src/main/java/io/ecocode/ios/swift/checks`.

Have a look at `swift-lang/src/main/java/io/ecocode/ios/swift/checks/idleness/IdleTimerDisabledCheck` to learn more about the implementation.

### Adding check to the visitor

Once implemented, add the new check to `swift-lang/src/main/java/io/ecocode/ios/swift/EcoCodeSwiftVisitor`.

For example:

```java
    public EcoCodeSwiftVisitor() {
        ...
        // Load checks
        checks.add(new MyNewCheck());
        ...
    }
```
