package at.willhaben.sp.hexample.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields
import com.tngtech.archunit.library.DependencyRules
import com.tngtech.archunit.library.GeneralCodingRules

@AnalyzeClasses(packages = ["at.willhaben.sp.hexample"])
class GeneralCodingRulesTest {

    @ArchTest
    val noUsageOfStdoutOrStderr: ArchRule = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS

    @ArchTest
    val noThrowingOfGenericExceptions: ArchRule = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS

    @ArchTest
    val noUsageOfFieldInjections: ArchRule =
        noFields().that().areDeclaredInClassesThat()
            .haveSimpleNameNotEndingWith("IT")
            .should(GeneralCodingRules.BE_ANNOTATED_WITH_AN_INJECTION_ANNOTATION)
            .`as`("no classes should use field injection")
            .because("field injection is considered harmful; use constructor injection or setter injection instead; see https://stackoverflow.com/q/39890849 for detailed explanations")

    @ArchTest
    val noUsageOfJavaVmLogging: ArchRule = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING

    @ArchTest
    val noUsageOfJodaTime: ArchRule = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME

    @ArchTest
    val noDependencyOnUpperPackages: ArchRule = DependencyRules.NO_CLASSES_SHOULD_DEPEND_UPPER_PACKAGES

}
