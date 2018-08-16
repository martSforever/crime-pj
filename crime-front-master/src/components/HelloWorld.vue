<template>
  <div class="hello">
    <h2>hello world !!!</h2>


    <div class="input-wrapper">
      姓名:
      <el-input v-model="student.name" size="small"></el-input>
      年龄：
      <el-input v-model="student.age" size="small"></el-input>
    </div>


    <el-button @click="list">查询数据</el-button>
    <el-button @click="insert">插入数据</el-button>
    <el-button @click="remove">删除数据</el-button>


    <div>
      <el-table
        :data="students"
        highlight-current-row ref="studentTable"
        @current-change="handleCurrentChange"
      >
        <el-table-column
          prop="id"
          label="id"
          width="180">
        </el-table-column>
        <el-table-column
          prop="age"
          label="年龄"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        students: [],
        currentRow: null,
        student: {
          name: null,
          age: null
        }
      }
    },
    methods: {
      handleCurrentChange(val) {
        this.currentRow = val;
      },

      async list() {
        this.startLoading()
        let resp = await axios.get(`http://127.0.0.1:8081/student/list`)
        this.stopLoading()
        this.students = resp.data
      },
      async insert() {
        this.startLoading()
        let resp = await axios.post(`http://127.0.0.1:8081/student/upsert`, this.student);
        this.stopLoading()
        if (!!resp.data) {
          this.$message('保存成功!');
          this.list()
        }
      },
      async remove() {
        if (!this.currentRow) {
          this.$message('请选择要删除的额数据!');
          return
        }
        this.startLoading()
        let resp = await axios.post(`http://127.0.0.1:8081/student/delete`, this.currentRow)
        this.stopLoading()
        if (!!resp.data) {
          this.$message('删除成功!');
          this.list()
        }
      },


      startLoading() {
        this.loading = this.$loading({
          lock: true,
          text: 'Loading',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });
      },
      stopLoading() {
        this.loading.close()
      },
    },
    mounted() {
      this.list()
    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .el-input {
    display: inline-block;
    width: 150px;
  }

  .input-wrapper {
    margin-bottom: 12px;
  }
</style>
