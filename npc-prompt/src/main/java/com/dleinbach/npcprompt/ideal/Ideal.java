package com.dleinbach.npcprompt.ideal;

import org.springframework.data.annotation.Id;

public record Ideal(@Id Long id, String text, String alignment) {
}
