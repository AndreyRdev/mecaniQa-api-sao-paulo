package br.com.mecaniQA.api.Dto;

import br.com.mecaniQA.api.Enums.StatusOrdemServico;


public class StatusChangeDTO {
    private StatusOrdemServico novoStatus;

    public StatusChangeDTO() {
    }

    public StatusChangeDTO(StatusOrdemServico novoStatus) {
        this.novoStatus = novoStatus;
    }

    public StatusOrdemServico getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(StatusOrdemServico novoStatus) {
        this.novoStatus = novoStatus;
    }

    @Override
    public String toString() {
        return "StatusChangeDTO{" +
                "novoStatus=" + novoStatus +
                '}';
    }
}