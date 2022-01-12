package com.dleinbach.npcprompt.flaw;

import org.springframework.data.annotation.Id;

public record Flaw(@Id Long id, String text) {
}
