import { Component, OnInit } from '@angular/core';
import { studentService } from '../student.service';
import { student } from '../student';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit{
  id: number;
  student: student = new student();
  constructor(private studentService: studentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.studentService.getStudentById(this.id).subscribe(data => {
      this.student= data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.studentService.updateStudent(this.id, this.student).subscribe( data =>{
      this.goToStudentList();
    }
    , error => console.log(error));
  }

  goToStudentList(){
    this.router.navigate(['/students']);
  }
}
