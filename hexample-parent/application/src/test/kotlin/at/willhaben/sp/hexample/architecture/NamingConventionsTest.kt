package at.willhaben.sp.hexample.architecture

import com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith
import com.tngtech.archunit.core.domain.properties.HasName.Predicates
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.conditions.ArchConditions.haveSimpleNameEndingWith
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController

@AnalyzeClasses(packages = ["at.willhaben.sp.hexample"])
class NamingConventionsTest {

    @ArchTest
    val configClassesAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(Configuration::class.java)
        .should().haveSimpleNameEndingWith("Config")

    @ArchTest
    val restControllerAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(RestController::class.java)
        .should().haveSimpleNameEndingWith("Controller")

    @ArchTest
    val serviceClassesAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(Service::class.java)
        .should().haveSimpleNameEndingWith("Service")

    @ArchTest
    val propertiesClassesAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(ConfigurationProperties::class.java)
        .should().haveSimpleNameEndingWith("Properties")

    @ArchTest
    val adapterClassesImplementingPortNamedProperly: ArchRule = classes()
        .that().resideInAPackage("..adapter..")
        .and().implement(Predicates.nameMatching(".*Port"))
        .should().haveSimpleNameEndingWith("Adapter")

    @ArchTest
    val adapterClassesInDomainShouldNotImplementSpringAnnotations: ArchRule = classes()
        .that().resideInAPackage("at.willhaben.sp.hexample.adapter..")
        .and().implement(Predicates.nameMatching(".*Port"))
        .should().notBeAnnotatedWith(Repository::class.java)
        .andShould().notBeAnnotatedWith(Service::class.java)
        .andShould().notBeAnnotatedWith(Configuration::class.java)

    @ArchTest
    val repositoryClassesAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(Repository::class.java)
        .should().haveSimpleNameEndingWith("Repository")
        .orShould(haveSimpleNameEndingWith("RepositoryDefault"))

    @ArchTest
    val portInterfacesAreNamedProperly: ArchRule = classes()
        .that().areInterfaces()
        .and()
        .resideInAPackage("..domain..ports..")
        .should().haveSimpleNameEndingWith("Port")

    @ArchTest
    val portPrefixOnlyInPortPackage: ArchRule = classes()
        .that().resideOutsideOfPackage("..domain..ports..")
        .should().haveSimpleNameNotEndingWith("Port")

    @ArchTest
    val unitTestClassesAreNamedProperly: ArchRule = classes()
        .that().containAnyMethodsThat(annotatedWith(Test::class.java))
        .and().areNotAnnotatedWith(SpringBootTest::class.java)
        .and().areNotMetaAnnotatedWith(SpringBootTest::class.java)
        .should().haveSimpleNameEndingWith("Test")

    @ArchTest
    val integrationTestClassesAreNamedProperly: ArchRule = classes()
        .that().areAnnotatedWith(SpringBootTest::class.java)
        .should().haveSimpleNameEndingWith("IT")
}
