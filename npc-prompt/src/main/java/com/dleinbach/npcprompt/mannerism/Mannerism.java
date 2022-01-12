package com.dleinbach.npcprompt.mannerism;

import org.springframework.data.annotation.Id;

public record Mannerism(@Id Long id, String text) {
}
