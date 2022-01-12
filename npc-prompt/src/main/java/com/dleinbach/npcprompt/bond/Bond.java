package com.dleinbach.npcprompt.bond;

import org.springframework.data.annotation.Id;

public record Bond(@Id Long id, String text) {
}
