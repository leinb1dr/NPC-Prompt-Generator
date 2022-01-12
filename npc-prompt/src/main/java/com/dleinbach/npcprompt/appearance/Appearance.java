package com.dleinbach.npcprompt.appearance;

import org.springframework.data.annotation.Id;

public record Appearance(@Id Long id, String text) {
}
