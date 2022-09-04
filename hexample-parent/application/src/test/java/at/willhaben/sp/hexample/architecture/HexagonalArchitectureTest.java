package at.willhaben.sp.hexample.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = {"at.willhaben.sp.hexample.adapter", "at.willhaben.sp.hexample.domain"})
public class HexagonalArchitectureTest {

    @ArchTest
    private ArchRule architecture_structure_is_respected = Architectures.onionArchitecture()
            .withOptionalLayers(true)
            .domainModels("at.willhaben.sp.hexample.domain..model..")
            .domainServices(
                    "at.willhaben.sp.hexample.domain..services..",
                    "at.willhaben.sp.hexample.domain..ports..")
            .adapter(
                    "input-rest",
                    "at.willhaben.sp.hexample.adapter.input.rest.."
            )
            .adapter(
                    "output-database",
                    "at.willhaben.sp.hexample.adapter.output.database.."
            )
            .adapter(
                    "output-recommendationengine",
                    "at.willhaben.sp.hexample.adapter.output.recommendation_engine.."
            );

}
