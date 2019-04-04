module.exports = {
  title: "rovo98's leetcode adventure",
  description: "Leetcode 解题报告",
  // 注入到当前页面的 HTML <head> 中的标签
  head: [
    ["link", { "rel": "icon", "href": "/favicon.png" }]
  ],
  base: "/leetcode-java-solutions/",
  markdown: {
    lineNumbers: true // 代码块行号显示
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
    sidebar: [
      // docs 文件夹下的文件夹
      {
        title: "Simple",
        children: [

        ]
      },
      {
        title: "Medium",
        children: [
          "/Medium/0937.K-Closest-Points-To-Origin"
        ]
      }
    ]
  }
}
