package com.xiwang.myai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.FileUrlResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class VectorAPI {

    private final VectorStore vectorStore;

    @RequestMapping("write")
    public String write() {
        // String desc = """
        //         Xiwang 低代码平台。Xiwang 是一款面向企业级应用的低代码开发平台，旨在提高软件开发效率，降低开发成本。该平台支持可视化建模、拖拽式组件拼装、自动代码生成，并提供强大的业务逻辑配置能力，使开发人员能够快速构建和交付高质量的应用程序。Xiwang 采用微服务架构，支持多租户 SaaS 部署，具备高度扩展性。平台内置丰富的 UI 组件库、流程引擎、数据建模工具，并支持集成常见的企业系统（如 ERP、CRM）。开发者可以通过自定义脚本扩展功能，满足复杂业务需求。同时，Xiwang 提供 API 网关，支持与外部系统无缝对接，提升企业数字化转型能力。目前，Xiwang 已在多个行业落地，包括金融、制造、医疗等领域，帮助企业加速应用开发，提升研发效能。未来，Xiwang 将继续优化用户体验，提供更智能的 AI 辅助开发功能，让低代码真正成为企业 IT 发展的新引擎。""";
        // vectorStore.write(Arrays.stream(desc.split("。")).map(Document::new).toList());
        PagePdfDocumentReader pagePdfDocumentReader = null;
        try {
            pagePdfDocumentReader = new PagePdfDocumentReader(new FileUrlResource("/Users/xiwang/Desktop/temp.pdf"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        vectorStore.write(pagePdfDocumentReader.get());
        return "success";
    }

}
