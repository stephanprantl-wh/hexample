package at.willhaben.sp.hexample.architecture;

import com.tngtech.archunit.core.domain.properties.HasName;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.lang.conditions.ArchConditions.haveSimpleNameEndingWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "at.willhaben.sp.hexample")
public class NamingConventionsTest {

    @ArchTest
    private ArchRule configClassesAreNamedProperly = classes()
            .that().areAnnotatedWith(Configuration.class)
            .should().haveSimpleNameEndingWith("Config");

    @ArchTest
    private ArchRule restControllerAreNamedProperly = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    private ArchRule serviceClassesAreNamedProperly = classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Service");

    @ArchTest
    private ArchRule propertiesClassesAreNamedProperly = classes()
            .that().areAnnotatedWith(ConfigurationProperties.class)
            .should().haveSimpleNameEndingWith("Properties");

    @ArchTest
    private ArchRule adapterClassesImplementingPortNamedProperly = classes()
            .that().resideInAPackage("..adapter..")
            .and().implement(HasName.Predicates.nameMatching(".*Port"))
            .should().haveSimpleNameEndingWith("Adapter");

    @ArchTest
    private ArchRule adapterClassesInDomainShouldNotImplementSpringAnnotations = classes()
            .that().resideInAPackage("at.willhaben.sp.hexample.adapter..")
            .and().implement(HasName.Predicates.nameMatching(".*Port"))
            .should().notBeAnnotatedWith(Repository.class)
            .andShould().notBeAnnotatedWith(Service.class)
            .andShould().notBeAnnotatedWith(Configuration.class);

    @ArchTest
    private ArchRule repositoryClassesAreNamedProperly = classes()
            .that().areAnnotatedWith(Repository.class)
            .should().haveSimpleNameEndingWith("Repository")
            .orShould(haveSimpleNameEndingWith("RepositoryDefault"));

    @ArchTest
    private ArchRule portInterfacesAreNamedProperly = classes()
            .that().areInterfaces()
            .and()
            .resideInAPackage("..domain..ports..")
            .should().haveSimpleNameEndingWith("Port");

    @ArchTest
    private ArchRule portPrefixOnlyInPortPackage = classes()
            .that().resideOutsideOfPackage("..domain..ports..")
            .should().haveSimpleNameNotEndingWith("Port");

    @ArchTest
    private ArchRule unitTestClassesAreNamedProperly = classes()
            .that().containAnyMethodsThat(annotatedWith(Test.class))
            .and().areNotAnnotatedWith(SpringBootTest.class)
            .and().areNotMetaAnnotatedWith(SpringBootTest.class)
            .should().haveSimpleNameEndingWith("Test");

    @ArchTest
    private ArchRule integrationTestClassesAreNamedProperly = classes()
            .that().areAnnotatedWith(SpringBootTest.class)
            .should().haveSimpleNameEndingWith("IT");

}
