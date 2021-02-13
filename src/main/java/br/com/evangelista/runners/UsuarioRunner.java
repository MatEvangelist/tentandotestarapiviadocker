package br.com.evangelista.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarentine",
        plugin = {"pretty", "html:target/reports/feature.html"},
        features = {"src/main/resources/features/"},
        monochrome = true,
        snippets = CAMELCASE
)
public class UsuarioRunner {
}

//wip - work in progress
