package br.com.mecaniQA.api.Dto;

import br.com.mecaniQA.api.Enums.StatusPedidoPecas;


public class StatusPedidoChangeDTO {
    private StatusPedidoPecas novoStatus;

    public StatusPedidoChangeDTO() {
    }

    public StatusPedidoChangeDTO(StatusPedidoPecas novoStatus) {
        this.novoStatus = novoStatus;
    }

    public StatusPedidoPecas getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(StatusPedidoPecas novoStatus) {
        this.novoStatus = novoStatus;
    }

    @Override
    public String toString() {
        return "StatusPedidoChangeDTO{" +
                "novoStatus=" + novoStatus +
                '}';
    }
}