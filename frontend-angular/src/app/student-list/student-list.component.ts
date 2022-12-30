import { Component, OnInit } from '@angular/core';
import { student } from '../student'
import { studentService } from '../student.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{
  student: student[];

  constructor(private studentService: studentService,
    private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents(){
    this.studentService.getStudentsList().subscribe(data => {
      this.student = data;
    });
  }

  studentDetails(id: number){
    this.router.navigate(['student-details', id]);
  }

  updateStudent(id: number){
    this.router.navigate(['update-student', id]);
  }

  deleteStudent(id: number){
    this.studentService.deleteStudent(id).subscribe( data => {
      console.log(data);
      this.getStudents();
    })
  }

}
