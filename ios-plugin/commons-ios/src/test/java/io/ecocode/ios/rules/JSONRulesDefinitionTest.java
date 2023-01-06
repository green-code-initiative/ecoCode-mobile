package io.ecocode.ios.rules;

import io.ecocode.ios.rules.JSONRulesDefinition;
import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONRulesDefinitionTest {

    @Test
    public void define() {

        JSONRulesDefinition rulesDefinition = new JSONRulesDefinition("rep_key", "rep_name", "lang", "/rules/rules.json") {};


        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);

        RulesDefinition.Repository repository = context.repository("rep_key");
        assertThat(repository).isNotNull();
        assertThat(repository.name()).isEqualTo("rep_name");
        assertThat(repository.language()).isEqualTo("lang");
        assertThat(repository.rules()).isNotEmpty();


    }
}
