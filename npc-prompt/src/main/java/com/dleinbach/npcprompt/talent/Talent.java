package com.dleinbach.npcprompt.talent;

import org.springframework.data.annotation.Id;

public record Talent(@Id Long id, String text) {
}
