package pl.cezarysanecki.archunitmodules.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.base.DescribedPredicate.not;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "pl.cezarysanecki.archunitmodules")
public class ArchModulesTest {

  @ArchTest
  public static final ArchRule ACCESS_TO_FIRST_INTERNAL_PACKAGES_CLASSES =
      noClasses()
          .that()
          .resideOutsideOfPackages("..first..")
          .should()
          .dependOnClassesThat(
              not(resideInAPackage("..first.api")).and(
                  resideInAPackage("..first.*")
              )
          )
          .as("cannot access internal packages of first package (except api)")
          .because("these are internal details of this package");

}
