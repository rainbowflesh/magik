<template>
  <div>
    <div ref="aoligei">
      <!--Layout布局-->
      <el-row>
        <el-col :span="24">
          <el-row :gutter="20">
            <el-col :span="6">
              <!--搜索区域-->
              <el-input
                placeholder="请输入内容"
                v-model="queryInfo.keyword"
                clearable
                @clear="getUserList"
              >
                <el-button
                  slot="append"
                  icon="el-icon-search"
                  @click="getUserList"
                ></el-button>
              </el-input>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="24">
          <!--表格-->
          <el-table
            :data="userList"
            border
            stripe
            @selection-change="handleSelectionChange"
          >
            <el-table-column
              type="index"
              label="序号"
              width="66"
            ></el-table-column>
            <el-table-column
              prop="userName"
              label="姓名"
              width="88"
            ></el-table-column>
            <el-table-column
              prop="gender"
              label="性别"
              width="88"
            ></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
          </el-table>
        </el-col>
      </el-row>
      <el-row>
        <!--分页区域-->
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryInfo.pageNo"
          :page-sizes="[9, 18, 30]"
          :page-size="queryInfo.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
        >
        </el-pagination>
      </el-row>
    </div>
  </div>
</template>

<script>
import { userList } from "@/api/user";
export default {
  data() {
    return {
      userList: [], // 用户列表
      userInfo: [],
      total: 0, // 用户总数
      // 获取用户列表的参数对象
      queryInfo: {
        keyword: "", // 查询参数
        pageNo: 1, // 当前页码
        pageSize: 9 // 每页显示条数
      },
      addDialogVisible: false, // 控制添加用户对话框是否显示
      userForm: {
        //用户
        loginName: "",
        userName: "",
        password: "",
        gender: "",
        email: "",
        address: ""
      },
      editDialogVisible: false, // 控制修改用户信息对话框是否显示
      editForm: {
        id: "",
        loginName: "",
        userName: "",
        password: "",
        gender: "",
        email: "",
        address: ""
      },
      multipleSelection: [],
      ids: []
    };
  },
  created() {
    // 生命周期函数
    this.getUserList();
  },
  methods: {
    getUserList() {
      userList(this.queryInfo)
        .then(res => {
          if (res.data.code === 200) {
            //用户列表
            this.userList = res.data.data.records;
            this.total = res.data.data.total;
          } else {
            this.$message.error(res.data.message);
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    loadData() {
      let p = this.query;
      let loadingInstance = this.$loading({
        target: this.$el,
        text: "拼命加载中",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.6)"
      });
      this.$axios
        .get(`/api/user/info`, {
          params: p
        })
        .then(
          v => {
            console.log(v);
            this.userInfo = v.data.data;
            this.queryInfo.total = v.data.total;
            loadingInstance.close();
          },
          r => {
            console.log("err ", r);
          }
        );
    },
    // 监听 pageSize 改变的事件
    handleSizeChange(newSize) {
      // console.log(newSize)
      this.queryInfo.pageSize = newSize;
      // 重新发起请求用户列表
      this.getUserList();
    },
    // 监听 当前页码值 改变的事件
    handleCurrentChange(newPage) {
      // console.log(newPage)
      this.queryInfo.pageNo = newPage;
      // 重新发起请求用户列表
      this.getUserList();
    }
  },
  mounted() {
    this.loadData();
  }
};
</script>

<style>
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.el-card {
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1) !important;
  height: 60pt;
}
</style>
