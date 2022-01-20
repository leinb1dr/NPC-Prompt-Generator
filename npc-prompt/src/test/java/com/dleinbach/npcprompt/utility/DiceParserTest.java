package com.dleinbach.npcprompt.utility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceParserTest {

    @Test
    public void testSimpleDiceFormula() {
        diceFormulaTest("1d20",1,20);
    }

    @Test
    public void testMultipleDiceFormula() {
        diceFormulaTest("2d12",2,24);
    }

    @Test
    public void testWithAddition() {
        diceFormulaTest("1d6+10",11,16);
    }

    @Test
    public void testWithSubtraction() {
        diceFormulaTest("1d6-10",-9,-4);
    }

    private void diceFormulaTest(String formula, int start, int end){
        DiceParser dp = DiceParser.parse(formula);
        assertThat(dp.calc()).isBetween(start, end);
    }
}
