<template>
  <div
    id="fatherContainer"
    v-bind:style="{ width: 150, height: 150, position: 'center' }"
  >
    <div
      id="img"
      v-bind:style="{ width: 150, height: 150, position: 'absolute' }"
    >
      <el-row>
        <el-col :span="8">
          <el-card :body-style="{ padding: '0px' }">
            <img src="../../assets/img/bitcoin.png" class="image" />
            <span></span>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <div class="日历">
      <el-collapse :value="['dayReport']">
        <el-collapse-item title="日期填报台账" name="dayReport">
          <el-calendar id="calendar">
            <template slot="dateCell" slot-scope="{ data }">
              <div class="calendar-day">
                {{ data.day.split("-").slice(1).join("-") }}
              </div>
              <p v-if="handleSelected(data.day) == 1">已填报</p>
              <p v-else>
                未填报
                <br />
                <a
                  :class="data.isSelected ? 'is-selected' : ''"
                  @click="
                    $model.planSjjdfkZdgcxxjdrtjtbBaseEdit.handleEdit(
                      'add',
                      data.day
                    )
                  "
                >
                  {{ data.isSelected ? "填报" : "" }}
                </a>
              </p>
            </template>
          </el-calendar>
        </el-collapse-item>
      </el-collapse>
    </div>
    <div id="liuhanHander">
      <ul class="liuhan_list">
        <li class="item" v-for="(n, index) in 1" :key="index">
          <div class="code-wrapper" v-show="index == showIndex">
            <img src="../../assets/img/bitcoin.png" alt="" />
          </div>
          <span class="name">流汗黄豆</span>
          <span>😅</span>
          <el-button
            class="filter-item"
            type="primary"
            @click="$router.push('/login')"
            >登出</el-button
          >
          <span class="introduce">"传递着爱与责任公平与正义"</span>
          <span
            class="yuyue"
            v-on:mouseover="showCode(index)"
            v-on:mouseleave="hideCode()"
            >点击流汗</span
          >
        </li>
      </ul>
    </div>
  </div>
</template>

<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
.img {
  height: 500;
}
.yuyue {
  text-align: center;
  margin: 0 auto;
  color: #ffae00;
  border: 1px solid #ffae00;
  padding: 10px 15px;
  width: 100px;
  border-radius: 10px;
  margin-top: 200px;
  font-size: 16px;
  cursor: pointer;
}
.mapContainer {
  height: 90px;
  width: 160;
}
.is-selected {
  color: #50da1a;
}
</style>

<script>
export default {
  data() {
    return {
      currentDate: new Date(),
    };
  },
  name: "service",
  data() {
    return {
      showIndex: null,
    };
  },
  methods: {
    handleSelected(day) {
      let flag = 0;
      console.log("动啊老铁");
      this.records.forEach((item) => {
        if (item.reportDate == day) {
          flag = item.reportStatus;
          return flag;
        }
      });
    },
    showCode(index) {
      this.showIndex = index;
    },
    hideCode() {
      this.showIndex = null;
    },
  },
  mounted: function () {},
};
</script>
