package vhgomes.com.ticketsti.dtos;

import vhgomes.com.ticketsti.models.Setor;

public record CreateTicketDTO(String title, String description, String category, Long setor) {
}