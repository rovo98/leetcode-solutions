module.exports = {
  title: "rovo98's leetcode adventure",
  description: "Leetcode 解题报告",
  // 注入到当前页面的 HTML <head> 中的标签
  head: [
    ["link", { "rel": "icon", "href": "/favicon.png" }],
    ["link", { rel: "stylesheet", href: "https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.css" }],
    ["link", { rel: "stylesheet", href: "https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/2.10.0/github-markdown.min.css" }]
  ],
  base: "/leetcode-java-solutions/",
  markdown: {
    lineNumbers: true, // 代码块行号显示
    config: md => {
      md.use(require("markdown-it-katex")),
      md.use(require("markdown-it-mark")),
      md.use(require("markdown-it-sup")),
      md.use(require("markdown-it-sub"))
    }
  },
  themeConfig: {
    nav: [
      { text: "个人博客",
        items: [
          { text: "rovo98's Blog(on GitPage)", link: "https://rovo98.github.io" },
          { text: "rovo98's Blog(on CodingPage)", link: "https://rovo98.coding.me" }
        ]
      },
      { text: "Github地址", link: "https://github.com/rovo98" }
    ],
    sidebar: "auto",
    displayAllHeaders: true, // 默认值 false
    lastUpdated: "Last Updated"
    // sidebar: [
    //   // docs 文件夹下的文件夹
    //   {
    //     title: "Simple",
    //     children: [
    //
    //     ]
    //   },
    //   {
    //     title: "Medium",
    //     children: [
    //       "/Medium/0937.K-Closest-Points-To-Origin"
    //     ]
    //   }
    // ]
  }
}
