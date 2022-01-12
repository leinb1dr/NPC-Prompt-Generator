package com.dleinbach.npcprompt.interaction;

import org.springframework.data.annotation.Id;

public record Interaction(@Id Long id, String text) {
}
