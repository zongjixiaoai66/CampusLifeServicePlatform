const base = {
    get() {
        return {
            url : "http://localhost:8080/xyshfwpt/",
            name: "xyshfwpt",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xyshfwpt/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园生活服务平台"
        } 
    }
}
export default base
