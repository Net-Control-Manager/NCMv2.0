package org.ncm.ncmv2.api;

import org.ncm.ncmv2.api.controller.NetController;
import org.ncm.ncmv2.api.dto.CreateNetRequest;
import org.ncm.ncmv2.app.service.NetService;
import org.ncm.ncmv2.domain.model.dto.NetDto;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*


import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.UUID;

import static javax.management.Query.eq;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@WebMvcTest(controllers = NetController.class)
@AutoConfigureRestDocs(outputDir = "${snippets.dir}")
class NetControllerRestDocsIT {
    @Autowired
    MockMvc mvc;
    @MockitoBean
    NetService service;

    @Test
    void documentCreateNet() throws Exception {
        var gid = UUID.randomUUID();
        var now = Instant.parse("2025-10-19T12:00:00Z");
        MockitoBean.when(service.create(eq(gid), any(CreateNetRequest.class))).thenReturn(new NetDto(UUID.randomUUID(), "Ops", UUID.randomUUID(), gid, now, null, false, null));
        var body = """
                {"name":"Ops","netTypeId":"00000000-0000-0000-0000-000000000001","startTime":"%s"}
                """.formatted(now);
        mvc.perform(post("/api/v1/groups/{gid}/nets", gid).contentType(MediaType.APPLICATION_JSON).
                content(body)).andExpect(status().isCreated()).andDo(document("net-create",
                requestFields(fieldWithPath("name").description("Net display name"), fieldWithPath("netTypeId").
                        description("Identifier of NetType"), fieldWithPath("startTime").description("Start timestamp (UTC)"),
                        fieldWithPath("preBuilt").optional().description("Prebuilt net flag")),
                responseFields(fieldWithPath("id").description("Net id"), fieldWithPath("name").description("Net name"),
                        fieldWithPath("netTypeId").description("NetType id"), fieldWithPath("groupId").description("Group id"),
                        fieldWithPath("startTime").description("Start"), fieldWithPath("closeTime").optional().description("Close"),
                        fieldWithPath("preBuilt").description("Prebuilt"), fieldWithPath("preBuiltTime").optional().description("Prebuild time"))));
    }

    @Test
    void documentCloseNet() throws Exception {
        var netId = UUID.randomUUID();
        Mockito.when(service.close(eq(netId))).thenReturn(new NetDto(netId, "Ops", UUID.randomUUID(), UUID.randomUUID(), Instant.parse("2025-10-19T12:00:00Z"), Instant.parse("2025-10-19T13:00:00Z"), false, null));
        mvc.perform(RestDocumentationRequestBuilders.post("/api/v1/nets/{id}:close", netId)).andExpect(status().isOk()).andDo(document("net-close"));
    }
}
